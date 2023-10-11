package com.artnest.springSecurity.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.artnest.springSecurity.dto.request.ArtRequestDto;
import com.artnest.springSecurity.dto.response.ArtResponse;
import com.artnest.springSecurity.service.ArtService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ArtController {

    private final ArtService artService;
    @PostMapping("/save")
	public ResponseEntity<String> saveart(@RequestBody ArtRequestDto artRequest){
		boolean isDataSaved=artService.saveArt(artRequest); 
		return isDataSaved ? ResponseEntity.status(200).body("art saved successfully"):
			ResponseEntity.status(403).body("Something went wrong");
	}

	@GetMapping("/all")
	public ResponseEntity<List<ArtResponse>> getAllArts() {
	 		List<ArtResponse> artList=artService.getAllArts();
		 	return artList.size()>0? ResponseEntity.status(200).body(artList):
		 		ResponseEntity.status(404).body(artList);
	}

    @PutMapping("/update/{artId}")
    public ResponseEntity<String> updateart(@PathVariable String artId, @RequestBody ArtRequestDto artRequest) {
        boolean isartUpdated = artService.updateArt(artId, artRequest);
            return isartUpdated ? ResponseEntity.status(200).body("art updated successfully") :
                ResponseEntity.status(404).body("art not found with ID: " + artId);
    }

    @DeleteMapping("/delete/{artId}")
    public ResponseEntity<String> deleteart(@PathVariable String artId) {
        
        boolean isartDeleted = artService.deleteArt(artId);
            return isartDeleted ? ResponseEntity.status(200).body("art deleted successfully") :
                ResponseEntity.status(404).body("art not found with ID: " + artId);
    }
    
}
