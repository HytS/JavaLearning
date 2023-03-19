public class CustomException {
    public static void main(String[] args) throws AgeException {
        int age = 80;
        if (!(age >= 18 && age <= 120)) {
            // 可以通过构造器输出信息
            throw new AgeException("age is wrong");
        }
        System.out.println("age is yes");
    }
}

// 自定义异常
// 一般情况，自定义异常继承RuntimeException
// 把自定义异常做成运行时异常，这样可以使用默认的处理机制
class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}
