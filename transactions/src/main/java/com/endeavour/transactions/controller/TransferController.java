package com.endeavour.transactions.controller;

import com.endeavour.transactions.entity.TransferRecord;
import com.endeavour.transactions.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfer")
public class TransferController
{
    private TransferService transferService;
    public TransferController(TransferService transferService)
    {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<String> transfer(@RequestBody TransferRecord  transferRecord)
    {
        transferService.transfer(transferRecord.getFromAccId(), transferRecord.getToAccId(), transferRecord.getAmount());
        return ResponseEntity.ok("DONE");
    }
}
