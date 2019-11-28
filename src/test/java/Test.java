import net.wangds.log.helper.LogHelper;

public class Test {

    @org.junit.Test
    public void test(){

        LogHelper.info(new Exception("1234132413241234aaaa"));
        LogHelper.info(()->"1234");
    }

}
