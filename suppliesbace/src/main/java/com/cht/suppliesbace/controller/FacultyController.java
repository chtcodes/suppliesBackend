package com.cht.suppliesbace.controller;

import com.cht.suppliesbace.model.APIResponseModel;
import com.cht.suppliesbace.model.Faculty;
import com.cht.suppliesbace.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
@CrossOrigin(origins = "http://localhost:4200")
public class FacultyController {




    @Autowired
    private FacultyService facultyService;

    //get all
    @GetMapping
    public APIResponseModel<List<Faculty>> getAllFaculties(){
        List<Faculty> facultyList = facultyService.getAllFaculties();


        APIResponseModel<List<Faculty>> response = new APIResponseModel<>();
        response.setStatus("success");
        response.setMessage("Faculties are fetched successfully.");
        response.setData(facultyList);

        return response;

    }

    //get by id
    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable Long id){
        return facultyService.getFacultyById(id);
    }


    //save
    @PostMapping
    public APIResponseModel<Faculty> createFaculty(@RequestBody Faculty faculty){

        Faculty savedFaculty = facultyService.saveFaculty(faculty);

        APIResponseModel<Faculty> response = new APIResponseModel<>();
        response.setStatus("success");
        response.setMessage("Faculty saved successfully.");
        response.setData(savedFaculty);

        return response;
    }

    //update
    @PutMapping("/{id}")
    public APIResponseModel<Faculty> updateFaculty(@PathVariable Long id, @RequestBody Faculty facultyDetails){
        Faculty savedFaculty =facultyService.updateFaculty(id,facultyDetails);

        APIResponseModel<Faculty> response = new APIResponseModel<>();
        response.setStatus("success");
        response.setMessage("Faculty updated successfully.");
        response.setData(savedFaculty);

        return response;
    }





    //delete
    @DeleteMapping("/{id}")
    public  APIResponseModel<String> deleteFaculty(@PathVariable Long id){
        facultyService.deleteFaculty(id);

        APIResponseModel<String> response = new APIResponseModel<>();
        response.setStatus("success");
        response.setMessage("Faculty deleted successfully.");
        response.setData("1 entry deleted");

        return response;
    }


}
