package jruyi.util;

import jakarta.annotation.Nullable;

import java.util.Objects;
import java.util.Properties;
import java.util.function.Supplier;

/**
 * <h2>系统属性</h2>
 *
 * @Date 2024-01-15 09:34
 */
@SuppressWarnings("unused")
public abstract class SystemProperties
{
    /**
     * 操作系统名称
     */
    public static final String OS_NAME = "os.name";
    /**
     * 操作系统版本
     */
    public static final String OS_VERSION = "os.version";
    /**
     * 操作系统默认字符编码
     */
    public static final String OS_ENCODING = "sun.jnu.encoding";
    /**
     * 运行当前 Java 程序的命令
     */
    public static final String OS_COMMAND = "sun.java.command";
    /**
     * 操作系统架构名称
     */
    public static final String OS_ARCH = "os.arch";
    /**
     * CPU 指令集
     */
    public static final String CPU_ISA_LIST = "sun.cpu.isalist";
    /**
     * CPU 数据位数，例如 32位 或 64位
     */
    public static final String CPU_DATA_MODEL = "sun.arch.data.model";
    /**
     * 系统用户当前工作目录
     */
    public static final String USER_DIR = "user.dir";
    /**
     * 系统用户名称
     */
    public static final String USER_NAME = "user.name";
    /**
     * 系统用户目录
     */
    public static final String USER_HOME = "user.home";
    /**
     * 系统用户变量
     */
    public static final String USER_VARIANT = "user.variant";
    /**
     * 系统用户国家代号，例如 CN
     */
    public static final String USER_COUNTRY = "user.country";
    /**
     * 系统用户语言代号，例如 zh
     */
    public static final String USER_LANGUAGE = "user.language";
    /**
     * 系统用户脚本
     */
    public static final String USER_SCRIPT = "user.script";
    /**
     * JVM 名称
     */
    public static final String JVM_NAME = "java.vm.name";
    /**
     * JVM 规范名称
     */
    public static final String JVM_SPEC_NAME = "java.vm.specification.name";
    /**
     * JVM 发行商
     */
    public static final String JVM_VENDOR = "java.vm.vendor";
    /**
     * JVM 发行商网址
     */
    public static final String JVM_VENDOR_URL = "java.vendor.url";
    /**
     * JVM 版本，例如 21.0.1+12-LTS-29
     */
    public static final String JVM_VERSION = "java.vm.version";
    /**
     * JVM 规范版本
     */
    public static final String JVM_SPEC_VERSION = "java.vm.specification.version";
    /**
     * JVM 规范发行商
     */
    public static final String JVM_SPEC_VENDOR = "java.vm.specification.vendor";
    /**
     * Java 运行名称
     */
    public static final String JAVA_RUN_NAME = "java.runtime.name";
    /**
     * Java 目录
     */
    public static final String JAVA_HOME = "java.home";
    /**
     * Java 版本
     */
    public static final String JAVA_VERSION = "java.version";
    /**
     * Java 规范版本
     */
    public static final String JAVA_SPEC_VERSION = "java.specification.version";
    /**
     * Java class 文件版本
     */
    public static final String JAVA_CLASS_VERSION = "java.class.version";
    /**
     * 当前 Java 版本发布日期
     */
    public static final String JAVA_VERSION_DATE = "java.version.date";
    /**
     * Java 规范名称
     */
    public static final String JAVA_SPEC_NAME = "java.specification.name";
    /**
     * Java 规范发行商
     */
    public static final String JAVA_SPEC_VENDOR = "java.specification.vendor";
    /**
     * Java 类路径
     */
    public static final String JAVA_CLASS_PATH = "java.class.path";
    /**
     * Java 发行版名称
     */
    public static final String JAVA_LAUNCHER = "sun.java.launcher";
    /**
     * Java bin 路径
     */
    public static final String JAVA_BIN_PATH = "sun.boot.library.path";
    /**
     * Java 可以搜索的所有路径，包括 bin 和 操作系统 Path，以 ';' 分隔
     */
    public static final String JAVA_LIB_PATH = "java.library.path";
    /**
     * Java 临时 IO 目录（例如：win 系统的 "C:\Users\{user.dir}\AppData\Local\Temp\"）
     */
    public static final String JAVA_TMP_DIR = "java.io.tmpdir";
    /**
     * Java bug 报告网址
     */
    public static final String JAVA_BUG_URL = "java.vendor.url.bug";
    /**
     * 当前系统的文件路径分隔符（例如：win 系统的 "\"）
     */
    public static final String FILE_SEPARATOR = "file.separator";
    /**
     * 当前系统的行分隔符（例如：win 系统的 "\r\n"）
     */
    public static final String LINE_SEPARATOR = "line.separator";
    /**
     * 当前系统的路径分隔符（例如：win 系统的 ";"）
     */
    public static final String PATH_SEPARATOR = "path.separator";
    /**
     * {@link System#out} 使用的字符编码
     */
    public static final String STDOUT_ENCODING = "stdout.encoding";
    /**
     * {@link System#err} 使用的字符编码
     */
    public static final String STDERR_ENCODING = "stderr.encoding";

    /**
     * @param props 属性列表
     * @see System#setProperties(Properties)
     */
    public static void set(@Nullable Properties props)
    {
        System.setProperties(props);
    }

    /**
     * @return 系统属性列表
     * @see System#setProperties(Properties)
     */
    public static Properties get()
    {
        return System.getProperties();
    }

    /**
     * 设置系统属性
     *
     * @param key   key 值
     * @param value value 值
     */
    public static void set(Object key, Object value)
    {
        System.setProperty(key.toString(), value.toString());
    }

    /**
     * 获取不到属性时默认返回 {@code null}
     *
     * @param key 参数 key
     * @return 系统参数
     */
    @Nullable
    public static String get(String key)
    {
        return get(key, (String) null);
    }

    /**
     * @param key          参数 key
     * @param defaultValue 获取不到结果时的替代值
     * @return 系统参数
     */
    @Nullable
    public static String get(String key, @Nullable String defaultValue)
    {
        Assert.notBlank(key, "the key to get system property is invalid");
        var property = System.getProperty(key);
        return StringUtil.isEmpty(property) ? defaultValue : property;
    }

    /**
     * @param key          参数 key
     * @param defaultValue 获取不到结果时的替代值
     * @return 系统参数
     */
    @Nullable
    public static String get(String key, Supplier<String> defaultValue)
    {
        Assert.notBlank(key, "the key to get system property is invalid");
        var property = System.getProperty(key);
        return StringUtil.isEmpty(property) ? defaultValue.get() : property;
    }

    /**
     * @param key     系统属性 key
     * @param replace 获取不到结果时的替代值
     * @return 布尔值形式的系统属性
     */
    public static int getDigit(String key, Supplier<Integer> replace)
    {
        var property = get(key);
        return property != null ? Integer.parseInt(property) : replace.get();
    }

    /**
     * @param key     系统属性 key
     * @param replace 获取不到结果时的替代值
     * @return 布尔值形式的系统属性
     */
    public static boolean getBoolean(String key, Supplier<Boolean> replace)
    {
        var property = get(key);
        return property == null ? replace.get() : Boolean.parseBoolean(property);
    }

    public static String osName() { return get(OS_NAME); }

    public static String osVersion() { return get(OS_VERSION); }

    public static String osCommand() { return get(OS_COMMAND); }

    public static String osEncoding() { return get(OS_ENCODING); }

    public static String osArch() { return get(OS_ARCH); }

    public static String cpuDataModel() { return get(CPU_DATA_MODEL); }

    public static String cpuIsaList() { return get(CPU_ISA_LIST); }

    public static String userCountry() { return get(USER_COUNTRY); }

    public static String userDir() { return get(USER_DIR); }

    public static String userHome() { return get(USER_HOME); }

    public static String userName() { return get(USER_NAME); }

    public static String userLanguage() { return get(USER_LANGUAGE); }

    public static String userScript() { return get(USER_SCRIPT); }

    public static String userVariant() { return get(USER_VARIANT); }

    public static String jvmName() { return get(JVM_NAME); }

    public static String jvmSpecName() { return get(JVM_SPEC_NAME); }

    public static String jvmVendor() { return get(JVM_VENDOR); }

    public static String jvmVendorUrl() { return get(JVM_VENDOR_URL); }

    public static String jvmSpecVendor() { return get(JVM_SPEC_VENDOR); }

    public static String jvmVersion() { return get(JVM_VERSION); }

    public static String jvmSpecVersion() { return get(JVM_SPEC_VERSION); }

    public static String javaRunName() { return get(JAVA_RUN_NAME); }

    public static String javaSpecName() { return get(JAVA_SPEC_NAME); }

    public static String javaVersion() { return get(JAVA_VERSION); }

    public static String javaSpecVersion() { return get(JAVA_SPEC_VERSION); }

    public static String javaVersionDate() { return get(JAVA_VERSION_DATE); }

    public static String javaClassVersion() { return get(JAVA_CLASS_VERSION); }

    public static String javaSpecVendor() { return get(JAVA_SPEC_VENDOR); }

    public static String javaLauncher() { return get(JAVA_LAUNCHER); }

    public static String javaHome() { return get(JAVA_HOME); }

    public static String javaBinPath() { return get(JAVA_BIN_PATH); }

    public static String javaClassPath() { return get(JAVA_CLASS_PATH); }

    public static String javaLibPath()
    {
        return get(JAVA_LIB_PATH);
    }

    public static String javaTmpDir() { return get(JAVA_TMP_DIR); }

    public static String javaBugUrl() { return get(JAVA_BUG_URL); }

    public static String fileSeparator() { return get(FILE_SEPARATOR); }

    public static String lineSeparator() { return get(LINE_SEPARATOR); }

    public static String pathSeparator() { return get(PATH_SEPARATOR); }

    public static String stdoutEncoding() { return get(STDOUT_ENCODING); }

    public static String stderrEncoding() { return get(STDERR_ENCODING); }
}