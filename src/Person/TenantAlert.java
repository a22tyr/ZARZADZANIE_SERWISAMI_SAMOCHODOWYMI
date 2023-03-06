package Person;

import Rooms.ConsumerWarehouse;
import Rooms.Warehouse;

import java.io.Serializable;

public class TenantAlert implements Serializable {
   private final ConsumerWarehouse consumerWarehouse;
   private final Person person;
    int cost;

    public TenantAlert(ConsumerWarehouse consumerWarehouse, Person person) {
        this.consumerWarehouse = consumerWarehouse;
        this.person = person;
        this.cost = consumerWarehouse.getWarehouseFees();
    }

    public ConsumerWarehouse getConsumerWarehouse() {
        return consumerWarehouse;
    }

    public Person getPerson() {
        return person;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
