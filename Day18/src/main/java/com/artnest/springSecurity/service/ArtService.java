package com.artnest.springSecurity.service;

import java.util.List;

import com.artnest.springSecurity.dto.request.ArtRequestDto;
import com.artnest.springSecurity.dto.response.ArtResponse;

public interface ArtService {

    public boolean saveArt(ArtRequestDto artRequest);
    public List<ArtResponse> getAllArts();

    public boolean updateArt(String artId, ArtRequestDto artRequest);

    public boolean deleteArt(String artId);
    
}
