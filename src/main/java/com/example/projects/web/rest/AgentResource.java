package com.example.projects.web.rest;

import com.example.projects.dto.AgentDTO;
import com.example.projects.service.AgentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AgentResource {

    private final AgentService agentService;

    public AgentResource(AgentService agentService) {
        this.agentService = agentService;
    }
    @GetMapping("/agents")
    public ResponseEntity<List<AgentDTO>> getListAgent(){
        List<AgentDTO> list = agentService.getListAgent();
        return ResponseEntity.ok().body(list);
    }
}
