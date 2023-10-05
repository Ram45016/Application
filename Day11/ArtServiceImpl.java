package com.artnest.springSecurity.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.artnest.springSecurity.dto.request.ArtRequestDto;
import com.artnest.springSecurity.dto.response.ArtResponse;
import com.artnest.springSecurity.dto.response.ProjectResponeDto;
import com.artnest.springSecurity.model.ArtUpload;
import com.artnest.springSecurity.model.Project;
import com.artnest.springSecurity.repository.ArtRepository;
import com.artnest.springSecurity.service.ArtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArtServiceImpl implements ArtService{

    private final ArtRepository artRepository;

    @Override
    public boolean saveArt(ArtRequestDto artRequest) {
        Optional<ArtUpload> isArtOptional=artRepository.existsByTitle(artRequest.getTitle());
        //projectRepository.existsByProjectName(projectRequest.getProjectName());
		if(isArtOptional.isPresent()){
			var art=ArtUpload.builder()
					.title(artRequest.getTitle())
					.fileLocation(artRequest.getFileLocation())
					.build();
			artRepository.save(art);
			return true;
		}
		else{
			return false;
		}
    }

    @Override
    public List<ArtResponse> getAllArts() {
       List<ArtUpload> artList = artRepository.findAll();
		List<ArtResponse> artResponseList = new ArrayList<>();
	
		for (ArtUpload art : artList) {
			ArtResponse artResponse = new ArtResponse(); 
			artResponse.setArtId(art.getArtId());
			artResponse.setTitle(art.getTitle());
			artResponse.setFileLocation(art.getFileLocation());
	
			artResponseList.add(artResponse);
		}
	
		return artResponseList;
    }

    @Override
    public boolean updateArt(String artId, ArtRequestDto artRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateArt'");
    }

    @Override
    public boolean deleteArt(String artId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteArt'");
    }
    
}
