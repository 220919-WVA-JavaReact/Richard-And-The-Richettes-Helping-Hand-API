package com.revature.helpinghandapi.controllers;
import com.revature.helpinghandapi.dtos.BidDTO;
import com.revature.helpinghandapi.dtos.ClientDTO;
import com.revature.helpinghandapi.dtos.RequestDTO;
import com.revature.helpinghandapi.dtos.Credentials;
import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.repositories.ClientRepository;
import com.revature.helpinghandapi.services.BidService;
import com.revature.helpinghandapi.services.ClientService;
import com.revature.helpinghandapi.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService cs;
    private final BidService bs;
    private final ClientRepository cr;
    private final RequestService rs;

    @Autowired
    public ClientController(ClientService cs, BidService bs, ClientRepository cr, RequestService rs){
        this.cs = cs;
        this.bs = bs;
        this.cr = cr;
        this.rs = rs;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClientDTO> createClient(@RequestBody Credentials cred) {
        ClientDTO clientDTO = cs.createClient(cred);
        return new ResponseEntity<>(clientDTO, HttpStatus.CREATED);
    }


    @GetMapping("/{clientId}/request/{requestId}/bids")
    public ResponseEntity<List<BidDTO>> getBidsByRequestId(@PathVariable("clientId") String clientId, @PathVariable("requestId") String requestId) {
        Optional<Client> client = cr.findById(clientId);
        List<BidDTO> bids = bs.getBidsByRequestId(requestId);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

    @GetMapping("/{id}/requests")
    public ResponseEntity<List<RequestDTO>> getRequestsByClientId(@PathVariable("id") String id) {
        List<RequestDTO> requests = rs.getRequestsByClientId(id);
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

}
