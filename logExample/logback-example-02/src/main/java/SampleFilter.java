
//自定义过滤器：继承Filter抽象类并实现该 decide()方法。
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

//消息字段中包含字符串 “qin” 则记录
public class SampleFilter extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (event.getMessage().contains("qin")) {
            return FilterReply.ACCEPT;
        } else {
            return FilterReply.DENY;
        }
    }
}
