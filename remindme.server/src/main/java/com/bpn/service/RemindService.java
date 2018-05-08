package com.bpn.service;

import com.bpn.entity.Remind;

import java.util.List;

public interface RemindService {
     List<Remind> getAll();
     Remind getById(long id);
     Remind save(Remind remind);
     void remove(long id);
}
