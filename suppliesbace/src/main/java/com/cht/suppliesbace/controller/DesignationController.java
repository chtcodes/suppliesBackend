package com.cht.suppliesbace.controller;

import com.cht.suppliesbace.model.APIResponseModel;
import com.cht.suppliesbace.model.Designation;
import com.cht.suppliesbace.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/designations")
@CrossOrigin(origins = "http://localhost:4200")
public class DesignationController {

//    @GetMapping("/")
//    public String printSome(){
//        return "Hello there";
//    }


    @Autowired
    private DesignationService designationService;

    @GetMapping
    public APIResponseModel<List<Designation>> getAllDesignations(){
        List<Designation> designationList = designationService.getAllDesignations();


        APIResponseModel<List<Designation>> response = new APIResponseModel<>();
        response.setStatus("success");
        response.setMessage("Designations fetched successfully.");
        response.setData(designationList);

        return response;

    }

    @GetMapping("/{id}")
    public Designation getDesignationById(@PathVariable Long id){
        return designationService.getDesignationById(id);
    }


    @PostMapping
    public APIResponseModel<Designation> createDesignation(@RequestBody Designation designation){

        Designation savedDesignation = designationService.saveDesignation(designation);

        APIResponseModel<Designation> response = new APIResponseModel<>();
        response.setStatus("success");
        response.setMessage("Designation saved successfully.");
        response.setData(savedDesignation);

        return response;
    }

    @PutMapping("/{id}")
    public APIResponseModel<Designation> updateDesignation(@PathVariable Long id, @RequestBody Designation designationDetails){
        Designation savedDesignation =designationService.updateDesignation(id,designationDetails);

        APIResponseModel<Designation> response = new APIResponseModel<>();
        response.setStatus("success");
        response.setMessage("Designation updated successfully.");
        response.setData(savedDesignation);

        return response;
    }






    @DeleteMapping("/{id}")
    public  APIResponseModel<String> deleteDesignation(@PathVariable Long id){
        designationService.deleteDesignation(id);

        APIResponseModel<String> response = new APIResponseModel<>();
        response.setStatus("success");
        response.setMessage("Designation deleted successfully.");
        response.setData("1 entry deleted");

        return response;
    }


}
