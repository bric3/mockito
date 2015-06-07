package org.mockito.internal.util;

public class Platform {
    /**
     * Current Java runtime version.
     *
     * Extracted from system property <code>java.version</code> with the following form : <code>x.y</code>
     */
    public static String JAVA_VERSION = System.getProperty("java.version").substring(0, "x.y".length());

    /**
     * Best guess to identify if this type come from the JDK.
     * <p/>
     * Comes from the manifest entry :
     * <pre class="code"><code class="text>
     * Implementation-Title: Java Runtime Environment
     * </code></pre>
     * <p/>
     * Note this entry is not necessarily present in every jar of that came with JDK. So if type can't
     * be identified as coming from the JDK return <code>false</code>.
     *
     * @param type The Class to check
     * @return yes or no
     */
    public static boolean isComingFromJDK(Class<?> type) {
        // Comes from the manifest entry :
        // Implementation-Title: Java Runtime Environment
        // This entry is not necessarily present in every jar of the JDK
        return type.getPackage() != null && "Java Runtime Environment".equalsIgnoreCase(type.getPackage().getImplementationTitle())
                || type.getName().startsWith("java.")
                || type.getName().startsWith("javax.");
    }


}
