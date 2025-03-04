package com.cht.suppliesbace.service;

import com.cht.suppliesbace.exceptions.ResourceNotFoundException;
import com.cht.suppliesbace.model.Faculty;
import com.cht.suppliesbace.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;


        //delete method
        public void deleteFaculty(Long id){
            Faculty faculty = facultyRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Faculty not found!"));
            facultyRepository.delete(faculty);
        }

        //get by id
        public Faculty getFacultyById(Long id){
            return facultyRepository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Faculty not found!"));
        }

        //get all
        public List<Faculty> getAllFaculties(){
            return  facultyRepository.findAll();
        }


        //save new
        public Faculty saveFaculty(Faculty faculty){
            return facultyRepository.save(faculty);

        }

        //update
        public Faculty updateFaculty(Long id, Faculty facultyDetails){
            Faculty faculty = facultyRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Faculty not found!"));
            faculty.setFacultyName(facultyDetails.getFacultyName());
            faculty.setCode(facultyDetails.getCode());
            return  facultyRepository.save(faculty);
        }



}
