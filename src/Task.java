public class Task {
    private String taskProduct;
    private int taskAmount;
    private int completedAmount;

    public Task(String taskProduct, int taskAmount) {
        this.taskProduct = taskProduct;
        this.taskAmount = taskAmount;
        this.completedAmount = 0;
    }

    public String getTaskProduct() {
        return taskProduct;
    }

    public void completeTask() {
        if (this.completedAmount < this.taskAmount)
            this.completedAmount++;
    }

    public boolean isDone() {
        return completedAmount == taskAmount;
    }

    public void showTask() {
        System.out.println(taskProduct + " " + completedAmount + "/" + taskAmount);
    }
}
