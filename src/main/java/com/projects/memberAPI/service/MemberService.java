package com.projects.memberAPI.service;

import com.projects.memberAPI.entity.Member;
import com.projects.memberAPI.repository.MemberRepository;
import org.apache.coyote.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private MemberRepository memberRepository;



    // findAll() function of the repository will get all the members easily
    // return is a list of Member objects
    public List<Member> getAllMembers() {
        return this.memberRepository.findAll();
    }



    // Need to use optional when finding by id because id could be null
    // Optionals can not be null. They are simply empty wrappers of the object inside of them
    // Optionals help manage null values
    public ResponseEntity<Object> findMemberById (long id) {
        Optional<Member> result = memberRepository.findById(id);

        if (result.isEmpty()) {
            return ResponseEntity.ok("Member does not exist");
        } else {
            return ResponseEntity.ok(result.get());
        }
    }




    // POST API that creates a new member into PG member table
    public ResponseEntity<Object> newMember(Member member) {
        memberRepository.save(member);
        logger.info("Post request to create new member is member PG table was called.");
        return new ResponseEntity<>(member, HttpStatus.CREATED);

        /**
         *  this is the JSON body for it. Any column not filled is null
         *  memberId and version are both autogenerate and do not need to be specified:
         *         {
         *             "firstName": "Haory please ntoice",
         *             "lastName": "Doe",
         *             "dateOfBirth": "1985-04-15",
         *             "enrollmentDate": "2023-01-01",
         *             "planName": "silver_advantage",
         *             "planType": "ppo",
         *             "coverageLevel": "individual",
         *             "premium": 350.75,
         *             "deductible": 1500.00,
         *             "outOfPocketMax": 7500.00,
         *             "phoneNumber": "555-123-4567",
         *             "email": "johndoe@example.com",
         *             "address": "123_elm_street",
         *             "city": "springfield",
         *             "state": "il",
         *             "zipCode": "62704",
         *             "gender": "male",
         *             "smoker": false,
         *             "preExistingConditions": "hypertension, asthma",
         *             "notes": "requires_specialist_for_asthma_management",
         *             "lastClaimDate": "2024-10-15",
         *             "claimAmount": 200.50
         *         }
         */
    }




    // PUT API to update a member
    public ResponseEntity<Object> updateMember (Long id, Member updatedMember) {
        Optional<Member> memberOptional = memberRepository.findById(id);

        if (!memberOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Member existingMember = memberOptional.get();

//        existingMember.setCity(updatedMember.getCity());
//        existingMember.setAddress(updatedMember.getAddress());
//        existingMember.setDeductible(updatedMember.getDeductible());
//        existingMember.setEmail(updatedMember.getEmail());
//        existingMember.setClaimAmount(updatedMember.getClaimAmount());
//        existingMember.setCoverageLevel(updatedMember.getCoverageLevel());
//        existingMember.setDateOfBirth(updatedMember.getDateOfBirth());
//        existingMember.setEnrollmentDate(updatedMember.getEnrollmentDate());
//        existingMember.setFirstName(updatedMember.getFirstName());
//        existingMember.setLastName(updatedMember.getLastName());
//        existingMember.setGender(updatedMember.getGender());
//        existingMember.setLastClaimDate(updatedMember.getLastClaimDate());
//        existingMember.setNotes(updatedMember.getNotes());
//        existingMember.setZipCode(updatedMember.getZipCode());
//        existingMember.setState(updatedMember.getState());
//        existingMember.setSmoker(updatedMember.getSmoker());
//        existingMember.setPremium(updatedMember.getPremium());
//        existingMember.setPreExistingConditions(updatedMember.getPreExistingConditions());
//        existingMember.setPlanName(updatedMember.getPlanName());
//        existingMember.setPlanType(updatedMember.getPlanType());
//        existingMember.setPhoneNumber(updatedMember.getPhoneNumber());
//        existingMember.setOutOfPocketMax(updatedMember.getOutOfPocketMax());

        // Copy non-null properties using the getNullPropertyNames function
        // This basically does existingMember.setProperty(updatedMember.getProperty()) for each property like above but more condensed and only non-nulls
        BeanUtils.copyProperties(updatedMember, existingMember, getNullPropertyNames(updatedMember));
        memberRepository.save(existingMember);

        return ResponseEntity.ok(existingMember);
    }

    // Helper method to identify null properties
    // The getNullPropertyNames function is a helper method designed to identify the properties of an object that are null.
    // These property names are used to exclude null fields
    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        return Arrays.stream(pds)
                .map(PropertyDescriptor::getName)
                .filter(propertyName -> src.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }




    // DELETE API to delete a member by Id
    public ResponseEntity<Object> deleteMember(Long id) {
        Optional<Member> result = memberRepository.findById(id);

        if (result.isPresent()) {
            memberRepository.delete(result.get());
            return ResponseEntity.ok("Member has been deleted");
        } else {
            return ResponseEntity.ok("Member not found");
        }
    }

}
