public class Computer {
    public void work(UsbInterface UsbInterface) {
        // 通过接口调用方法
        UsbInterface.start();
        UsbInterface.stop();
    }
}
