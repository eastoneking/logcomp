package net.wangds.log.helper;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public final class LogHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogHelper.class);

    private static Logger buildLogger(Logger logger){
        if(logger==null){
            Throwable where = new Throwable();
            StackTraceElement st = where.getStackTrace()[2];
            String clzName = st.getClassName();
            //String method = st.getMethodName();
            //int line = st.getLineNumber();
            //logger = LoggerFactory.getLogger(clzName+"#"+method+"@"+line);
            logger = LoggerFactory.getLogger(clzName);
        }
        return logger;
    }

    private static String buildMsg( Supplier<String> msgFac, Throwable e){
        String msg = "";
        if (msgFac!=null){
            msg = msgFac.get();
        }
        if(StringUtils.isBlank(msg)){
            if(e!=null) {
                msg = e.getLocalizedMessage();
            }
        }
        return msg;
    }

    private static void log(Supplier<Boolean> levelEnableTest, BiConsumer<String, Throwable> logFunc, Supplier<String> msgFac, Throwable e){
        if(levelEnableTest==null?true:levelEnableTest.get()){
            logFunc.accept(buildMsg(msgFac, e), e);
        }
    }

    public static void trace(Logger logger, Supplier<String> facMsg, Throwable e){
        logger = buildLogger(logger);
        log(logger::isTraceEnabled, logger::trace, facMsg, e);
    }

    public static void debug(Logger logger, Supplier<String> facMsg, Throwable e){
        logger = buildLogger(logger);
        log(logger::isDebugEnabled, logger::debug, facMsg, e);
    }

    public static void info(Logger logger, Supplier<String> facMsg, Throwable e){
        logger = buildLogger(logger);
        log(logger::isInfoEnabled, logger::info, facMsg, e);
    }

    public static void warn(Logger logger, Supplier<String> facMsg, Throwable e){
        logger = buildLogger(logger);
        log(logger::isWarnEnabled, logger::warn, facMsg, e);
    }

    public static void error(Logger logger, Supplier<String> facMsg, Throwable e){
        logger = buildLogger(logger);
        log(logger::isErrorEnabled, logger::error, facMsg, e);
    }

    public static void trace(Logger logger, Supplier<String> facMsg){
        logger = buildLogger(logger);
        log(logger::isTraceEnabled, logger::trace, facMsg, null);
    }

    public static void debug(Logger logger, Supplier<String> facMsg){
        logger = buildLogger(logger);
        log(logger::isDebugEnabled, logger::debug, facMsg, null);
    }

    public static void info(Logger logger, Supplier<String> facMsg){
        logger = buildLogger(logger);
        log(logger::isInfoEnabled, logger::info, facMsg, null);
    }

    public static void warn(Logger logger, Supplier<String> facMsg){
        logger = buildLogger(logger);
        log(logger::isWarnEnabled, logger::warn, facMsg, null);
    }

    public static void error(Logger logger, Supplier<String> facMsg){
        logger = buildLogger(logger);
        log(logger::isErrorEnabled, logger::error, facMsg, null);
    }

    public static void trace(Logger logger, Throwable e){
        logger = buildLogger(logger);
        log(logger::isTraceEnabled, logger::trace, null, e);
    }

    public static void debug(Logger logger, Throwable e){
        logger = buildLogger(logger);
        log(logger::isDebugEnabled, logger::debug, null, e);
    }

    public static void info(Logger logger, Throwable e){
        logger = buildLogger(logger);
        log(logger::isInfoEnabled, logger::info, null, e);
    }

    public static void warn(Logger logger, Throwable e){
        logger = buildLogger(logger);
        log(logger::isWarnEnabled, logger::warn, null, e);
    }

    public static void error(Logger logger, Throwable e){
        logger = buildLogger(logger);
        log( logger::isErrorEnabled, logger::error, null, e);
    }

    public static void trace(Class clz, Supplier<String> facMsg, Throwable e){
        Logger logger = LoggerFactory.getLogger(clz);
        log(logger::isTraceEnabled, logger::trace, facMsg, e);
    }

    public static void debug(Class clz, Supplier<String> facMsg, Throwable e){
        Logger logger = LoggerFactory.getLogger(clz);
        log(logger::isDebugEnabled, logger::debug, facMsg, e);
    }

    public static void info(Class clz, Supplier<String> facMsg, Throwable e){
        Logger logger = LoggerFactory.getLogger(clz);
        log(logger::isInfoEnabled, logger::info, facMsg, e);
    }

    public static void warn(Class clz, Supplier<String> facMsg, Throwable e){
        Logger logger = LoggerFactory.getLogger(clz);
        log(logger::isWarnEnabled, logger::warn, facMsg, e);
    }

    public static void error(Class clz, Supplier<String> facMsg, Throwable e){
        Logger logger = LoggerFactory.getLogger(clz);
        log(logger::isErrorEnabled, logger::error, facMsg, e);
    }

    public static void trace(Class clz, Supplier<String> facMsg){
        Logger logger = LoggerFactory.getLogger(clz);
        log(logger::isTraceEnabled, logger::trace, facMsg, null);
    }

    public static void debug(Class clz, Supplier<String> facMsg){
        Logger logger = LoggerFactory.getLogger(clz);
        log(logger::isDebugEnabled, logger::debug, facMsg, null);
    }

    public static void info(Class clz, Supplier<String> facMsg){
        Logger logger = LoggerFactory.getLogger(clz);
        log(logger::isInfoEnabled, logger::info, facMsg, null);
    }

    public static void warn(Class clz, Supplier<String> facMsg){
        Logger logger = LoggerFactory.getLogger(clz);
        log(logger::isWarnEnabled, logger::warn, facMsg, null);
    }

    public static void error(Class clz, Supplier<String> facMsg){
        Logger logger = LoggerFactory.getLogger(clz);
        log(logger::isErrorEnabled, logger::error, facMsg, null);
    }

    public static void trace(Class clz, Throwable e){
        Logger logger = LoggerFactory.getLogger(clz);
        log(logger::isTraceEnabled, logger::trace, null, e);
    }

    public static void debug(Class clz, Throwable e){
        Logger logger = LoggerFactory.getLogger(clz);
        log(logger::isDebugEnabled, logger::debug, null, e);
    }

    public static void info(Class clz, Throwable e){
        Logger logger = LoggerFactory.getLogger(clz);
        log(logger::isInfoEnabled, logger::info, null, e);
    }

    public static void warn(Class clz, Throwable e){
        Logger logger = LoggerFactory.getLogger(clz);
        log(logger::isWarnEnabled, logger::warn, null, e);
    }

    public static void error(Class clz, Throwable e){
        Logger logger = LoggerFactory.getLogger(clz);
        log( logger::isErrorEnabled, logger::error, null, e);
    }

    public static void trace(Supplier<String> facMsg, Throwable e){
        Logger logger = buildLogger(null);
        log(logger::isTraceEnabled, logger::trace, facMsg, e);
    }

    public static void debug(Supplier<String> facMsg, Throwable e){
        Logger logger = buildLogger(null);
        log(logger::isDebugEnabled, logger::debug, facMsg, e);
    }

    public static void info(Supplier<String> facMsg, Throwable e){
        Logger logger = buildLogger(null);
        log(logger::isInfoEnabled, logger::info, facMsg, e);
    }

    public static void warn(Supplier<String> facMsg, Throwable e){
        Logger logger = buildLogger(null);
        log(logger::isWarnEnabled, logger::warn, facMsg, e);
    }

    public static void error(Supplier<String> facMsg, Throwable e){
        Logger logger = buildLogger(null);
        log(logger::isErrorEnabled, logger::error, facMsg, e);
    }

    public static void trace(Supplier<String> facMsg){
        Logger logger = buildLogger(null);
        log(logger::isTraceEnabled, logger::trace, facMsg, null);
    }

    public static void debug(Supplier<String> facMsg){
        Logger logger = buildLogger(null);
        log(logger::isDebugEnabled, logger::debug, facMsg, null);
    }

    public static void info(Supplier<String> facMsg){
        Logger logger = buildLogger(null);
        log(logger::isInfoEnabled, logger::info, facMsg, null);
    }

    public static void warn(Supplier<String> facMsg){
        Logger logger = buildLogger(null);
        log(logger::isWarnEnabled, logger::warn, facMsg, null);
    }

    public static void error(Supplier<String> facMsg){
        Logger logger = buildLogger(null);
        log(logger::isErrorEnabled, logger::error, facMsg, null);
    }

    private static Supplier<String> defaultNullMsgFac = ()->null;

    public static void trace(Throwable e){
        Logger logger = buildLogger(null);
        log(logger::isTraceEnabled, logger::trace, defaultNullMsgFac, e);
    }

    public static void debug(Throwable e){
        Logger logger = buildLogger(null);
        log(logger::isDebugEnabled, logger::debug, defaultNullMsgFac, e);
    }

    public static void info(Throwable e){
        Logger logger = buildLogger(null);
        log(logger::isInfoEnabled, logger::info, defaultNullMsgFac, e);
    }

    public static void warn(Throwable e){
        Logger logger = buildLogger(null);
        log(logger::isWarnEnabled, logger::warn, defaultNullMsgFac, e);
    }

    public static void error(Throwable e){
        Logger logger = buildLogger(null);
        log(logger::isErrorEnabled, logger::error, defaultNullMsgFac, e);
    }


    public static void trace(String msg){
        Logger logger = buildLogger(null);
        log(logger::isTraceEnabled, logger::trace, ()->msg, null);
    }

    public static void debug(String msg){
        Logger logger = buildLogger(null);
        log(logger::isDebugEnabled, logger::debug, ()->msg, null);
    }

    public static void info(String msg){
        Logger logger = buildLogger(null);
        log(logger::isInfoEnabled, logger::info, ()->msg, null);
    }

    public static void warn(String msg){
        Logger logger = buildLogger(null);
        log(logger::isWarnEnabled, logger::warn, ()->msg, null);
    }

    public static void error(String msg){
        Logger logger = buildLogger(null);
        log(logger::isErrorEnabled, logger::error, ()->msg, null);
    }

}
