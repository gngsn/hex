package com.gngsn.ditto.support

import org.springframework.stereotype.Component

/**
 * Indicates that an annotated class is an "adapter". Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Component
annotation class Adapter(

    /**
     * The value may indicate a suggestion for a logical component name,
     * to be turned into a Spring bean in case of an autodetect component.
     * @return the suggested component name, if any (or empty String otherwise)
     */
    val value: String = ""
)
