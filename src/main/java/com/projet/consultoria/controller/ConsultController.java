package com.projet.consultoria.controller;

import com.projet.consultoria.model.Clientes;
import com.projet.consultoria.model.UserExcelExporter;
import com.projet.consultoria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@RestController
@RequestMapping("/")
public class ConsultController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping(path = "client/list")
    public List<Clientes> listar(){
        return clienteRepository.findAll();
    }

    @GetMapping(path = "cli/{id}")
    public ResponseEntity consultClientId(@PathVariable Integer id){
        return clienteRepository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("save")
    public void saves(@RequestBody Clientes clientes){
        clienteRepository.save(clientes);
    }

    @DeleteMapping("client/delete/{id}")
    public String delete(@PathVariable Integer id){
        clienteRepository.deleteById(id);
        return "cliente deletado com sucesso";
    }

    @DeleteMapping("delete/{id}")
    public void deletarEvento(Integer codigo){
        clienteRepository.deleteById(codigo);
    }
    @PutMapping("/update")
    public Clientes update(@RequestBody Clientes clientes){
        return clienteRepository.save(clientes);
    }

//    @GetMapping
//    public ModelAndView listClient(){
//        ModelAndView mv = new ModelAndView("index");
//        Iterable<Clientes> client =  clienteRepository.findAll();
//        mv.addObject("client", client);
//        return mv;
//    }


//    @RequestMapping("/keyword")
//    public String viewHomePage(Model model, @Param("keyword") String keyword) {
//
//        List<Clientes> listProducts = clientService.listAll(keyword);
//        model.addAttribute("client", listProducts);
//        model.addAttribute("keyword", keyword);
//        return "redirect:/index";
//    }

//    @GetMapping("search")
//    public ModelAndView showEventsByName(@RequestParam (value = "search", required = false) String name, Model model) {
//        ModelAndView mv = new ModelAndView("search");
//        Iterable<Clientes> client =  clienteRepository.findAll();
//        model.addAttribute("event", client);
//        mv.addObject("event", client);
//        mv.addObject("searchResult", clienteRepository.findByName(name));
//        model.addAttribute("searchResult", clienteRepository.findByName(name));
//        return mv;
//    }

    @GetMapping("export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=clientes_" + currentDateTime + ".xlsx";
        response.setContentType("text/csv");
        response.setHeader(headerKey, headerValue);

        List<Clientes> listUsers = clienteRepository.findAll();


        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"User ID", "Name", "Peso", "Product", "Value_Product"};
        String[] nameMapping = {"id", "name", "peso", "product", "valProd"};

        csvWriter.writeHeader(csvHeader);

        for (Clientes user : listUsers) {
            csvWriter.write(user, nameMapping);
        }

        csvWriter.close();

//        UserExcelExporter excelExporter = new UserExcelExporter(listUsers);
//
//        excelExporter.export(response);
    }
    @PostMapping
    public ModelAndView save(Clientes clientes){
        ModelAndView mv = new ModelAndView("index");
        clienteRepository.save(clientes);
        return mv;
    }
    @GetMapping("edit")
    public ModelAndView save2(Clientes clientes){
        ModelAndView mv = new ModelAndView("index");
        clienteRepository.save(clientes);
        return mv;
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Integer id, Pageable pageable) {
        ModelAndView mv = new ModelAndView("evento/delete");
        Clientes user = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        clienteRepository.delete(user);
        clienteRepository.findAll(pageable);
        return mv;
    }

    @GetMapping
    public ModelAndView showEventsByName(@RequestParam (value = "search", required = false) String name, Pageable pageable){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Clientes> client;
        if(name == null){
            mv.addObject("client", clienteRepository.findAll(pageable));
            mv.addObject("totalPages", pageable.getPageNumber());
            mv.addObject("totalItems", pageable.getPageSize());
            return mv;
        }else {
            client = clienteRepository.findByName(name);
        }
        mv.addObject("client", client);
        return mv;
    }
}

