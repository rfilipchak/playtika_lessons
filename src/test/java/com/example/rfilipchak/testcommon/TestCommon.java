package com.example.rfilipchak.testcommon;

import com.example.rfilipchak.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
public class TestCommon {
    private Game slots = new Game(new HashSet<>());

    private Address vatutina = new Address("vatutina,1","Kiev");
    private Address gagarina = new Address("gagarina,16", "Kiev");
    private Address kievskaya = new Address("kievskaya,1","Vinnica");
    private Address umanskaya = new Address("umanskaya,1","Vinnica");
    private  Address notExistingAddress = new Address("volinskf,1","Lutsk");


    private Region vinnickiy = new Region("Vinnickiy", new HashSet<>());
    private Region kievskiy = new Region("Kievskiy", new HashSet<>());

    private City kiev = new City("Kiev", new HashSet<>());
    private City vinnica = new City("Vinnica", new HashSet<>());

    private DataCenter dataCenter1 = new DataCenter("dataCenter1", new HashSet<>());
    private DataCenter dataCenter2 = new DataCenter("dataCenter2", new HashSet<>());


    protected void gameModelSetUp() {
        kiev.getAddresses().add(vatutina);
        kiev.getAddresses().add(gagarina);

        vinnica.getAddresses().add(kievskaya);
        vinnica.getAddresses().add(umanskaya);

        kievskiy.getCitySet().add(kiev);
        vinnickiy.getCitySet().add(vinnica);

        dataCenter1.getRegions().add(kievskiy);
        dataCenter2.getRegions().add(vinnickiy);

        slots.getDataCenters().add(dataCenter1);
        slots.getDataCenters().add(dataCenter2);
    }

    protected Set<Region> getRegions(){
        HashSet<Region> regions = new HashSet<>();
        regions.add(kievskiy);
        regions.add(vinnickiy);
        return regions;
    }
}
