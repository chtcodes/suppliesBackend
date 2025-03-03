package com.cht.suppliesbace.service;

import com.cht.suppliesbace.exceptions.ResourceNotFoundException;
import com.cht.suppliesbace.model.Designation;
import com.cht.suppliesbace.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class DesignationService {

    @Autowired
    private DesignationRepository designationRepository;


        //delete method
        public void deleteDesignation(Long id){
            Designation designation = designationRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Designation not found!"));
            designationRepository.delete(designation);
        }

        //get by id
        public Designation getDesignationById(Long id){
            return designationRepository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Designation not found!"));
        }

        //get all
        public List<Designation> getAllDesignations(){
            return  designationRepository.findAll();
        }


        //save new
        public Designation saveDesignation(Designation designation){
            return designationRepository.save(designation);

        }

        //update
        public Designation updateDesignation(Long id, Designation designationDetails){
            Designation designation = designationRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Designation not found!"));
            designation.setDesignationName(designationDetails.getDesignationName());
            designation.setGrade(designationDetails.getGrade());
            return  designationRepository.save(designation);
        }



}
