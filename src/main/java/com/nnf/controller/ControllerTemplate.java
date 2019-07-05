package com.nnf.controller;

import com.nnf.domain.DomainObjectTemplate;
import com.nnf.dto.DomainTransferObjectTemplate;
import com.nnf.service.ServiceTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class ControllerTemplate {

    @Autowired
    ServiceTemplate serviceTemplate;

    private static Logger logger = LoggerFactory.getLogger(ControllerTemplate.class);

    @GetMapping("/")
    public String serveTemplate(Model model) {

        if (!model.containsAttribute("templateForm")) {
            DomainTransferObjectTemplate dto = new DomainTransferObjectTemplate();
            model.addAttribute("templateForm", dto);
        }

        return "template-form";
    }

    @PostMapping("/")
    public String saveTemplate(@ModelAttribute DomainTransferObjectTemplate dtoForm, Model model) {

        DomainObjectTemplate rowEntry = serviceTemplate.saveTemplate(dtoForm);
        DomainTransferObjectTemplate convertedDTO = serviceTemplate.findTemplate(rowEntry);

        List<String> info = new ArrayList<>();
        List<String> errors = new ArrayList<>();

        if (convertedDTO.getFieldName().compareTo(dtoForm.getFieldName()) == 0) {
            info.add("Successfully saved Template DTO");
            model.addAttribute("info", info);
            model.addAttribute("dtoEntry", convertedDTO);
        } else {
            errors.add("Failed to compare saved and received Template DTO");
            model.addAttribute("errors", errors);
        }

        DomainTransferObjectTemplate dto = new DomainTransferObjectTemplate();
        model.addAttribute("templateForm", dto);

        return "template-form";
    }

    @GetMapping("/records")
    public String findRecord(@ModelAttribute DomainTransferObjectTemplate dtoEntry, Model model) {

        List<String> info = new ArrayList<>();
        List<DomainTransferObjectTemplate> data = new ArrayList<>();

        DomainTransferObjectTemplate convertedDTO = serviceTemplate.findDTOById(dtoEntry);
        if (convertedDTO != null) {
            data.add(convertedDTO);
        } else {
            info.add("Could not find any data");
        }


        model.addAttribute("info", info);
        model.addAttribute("data", data);

        return "record-template";
    }

    @GetMapping("/all-entries")
    public String findAllRecords(Model model) {

        List<DomainTransferObjectTemplate> data = serviceTemplate.allTemplates();

        List<String> info = new ArrayList<>();

        if (data.isEmpty()) {
            info.add("Could not find any data");
        }

        model.addAttribute("info", info);
        model.addAttribute("data", data);

        return "all-records-template";
    }

    @GetMapping("/error")
    public String serveError(Model model) {

        Date date = Calendar.getInstance().getTime();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(date);

        logger.error("Error occurred, see what happened in logs, and fix it, now.");

        return "error";
    }

}
