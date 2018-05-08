package com.bpn.controller;


import com.bpn.entity.Remind;
import com.bpn.service.RemindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReminderController {

    @Autowired
    private RemindService service;

    @RequestMapping(value = "/reminders", method = RequestMethod.GET )
    @ResponseBody
    public List<Remind> getAllReminders(){
        return service.getAll();
    }


    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.GET )
    @ResponseBody
    public Remind getRemind (@PathVariable("id") long remindId){
        return service.getById(remindId);
    }

    @RequestMapping(value = "/reminders", method = RequestMethod.POST )
    @ResponseBody
    public Remind saveRemind (@RequestBody Remind remind){
        return service.save(remind);
    }

    @RequestMapping(value = "/reminders/delete/{id}", method = RequestMethod.DELETE )
    @ResponseBody
    public void deleteRemind (@PathVariable("id") long remindId){
        service.remove(remindId);
    }
}
