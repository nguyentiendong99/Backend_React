package com.example.projects.web.rest;

import com.example.projects.domain.Agents;
import com.example.projects.dto.AgentDTO;
import com.example.projects.service.AgentService;
import com.example.projects.service.mapper.AgentMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AgentResource {

    private final AgentService agentService;
    private final AgentMapper agentMapper;
    public AgentResource(AgentService agentService, AgentMapper agentMapper) {
        this.agentService = agentService;
        this.agentMapper = agentMapper;
    }
    @GetMapping("/agents")
    public ResponseEntity<Page<Agents>> getListAgent(int pageNumber , int pageSize){
        Page<Agents> page = agentService.getListAgent(
                PageRequest.of(
                        pageNumber , pageSize
                )
        );
        return ResponseEntity.ok().body(page);
    }
    @GetMapping("/agents/stock/{id}")
    public ResponseEntity<Page<Agents>> getListAgentByStockId(@PathVariable("id") Integer id ,
                                                              int pageNumber , int pageSize){
        Page<Agents> page = agentService.getListAgentByStockId(id ,
                PageRequest.of(
                        pageNumber , pageSize
                ));
        return ResponseEntity.ok().body(page);
    }
}
