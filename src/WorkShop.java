public class WorkShop {
    private final int BUILD_COST;
    private final int PRODUCE_TIME;
    private int workshopLevel = 1;
    private final String REQUIRED_RAW_MATERIAL;
    private boolean isBusy;

    public WorkShop(int BUILD_COST, int PRODUCE_TIME, String REQUIRED_RAW_MATERIAL) {
        this.BUILD_COST = BUILD_COST;
        this.PRODUCE_TIME = PRODUCE_TIME;
        this.isBusy = false;
        this.REQUIRED_RAW_MATERIAL = REQUIRED_RAW_MATERIAL;
    }

    public String getWorkShopName() {
        return "WorkShop";
    }

    public void work() {
        if (this.isBusy()) {
            System.out.println("workshop is busy");
            return;
        }
        if (getWorkshopLevel() == 1) {
            if (WareHouse.findItem(REQUIRED_RAW_MATERIAL) != null) {
                WareHouse.removeFromWarehouse(WareHouse.findItem(REQUIRED_RAW_MATERIAL));
                this.start();
                workLevel1();
            } else {
                System.out.println("required items not found");
            }
        } else {
            if (WareHouse.findItem(REQUIRED_RAW_MATERIAL) != null) {
                WareHouse.removeFromWarehouse(WareHouse.findItem(REQUIRED_RAW_MATERIAL));
                if (WareHouse.findItem(REQUIRED_RAW_MATERIAL) != null) {
                    WareHouse.removeFromWarehouse(WareHouse.findItem(REQUIRED_RAW_MATERIAL));
                    this.start();
                    workLevel2Normal();
                } else {
                    this.start();
                    workLevel2Fast();
                }
            } else {
                System.out.println("required items not found");
            }
        }
    }

    public int getWorkshopLevel() {
        return workshopLevel;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void doneWorking() {
        this.isBusy = false;
    }

    protected void start() {
        System.out.println(getWorkShopName() + " work started");
        this.isBusy = true;
    }

    protected void workLevel1() {
    }

    protected void workLevel2Normal() {
    }

    protected void workLevel2Fast() {
    }
}
