public class Task {
    private String taskProduct;
    private int taskAmount;
    private int completedAmount;

    public Task(String taskProduct, int taskAmount) {
        this.taskProduct = taskProduct;
        this.taskAmount = taskAmount;
        this.completedAmount = 0;
    }

    public void showTask() {
        System.out.println(taskProduct + " " + completedAmount + "/" + taskAmount);
    }
}
