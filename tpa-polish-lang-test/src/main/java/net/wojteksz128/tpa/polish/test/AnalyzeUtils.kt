package net.wojteksz128.tpa.polish.test

import java.math.BigInteger
import java.security.MessageDigest

object AnalyzeUtils {

    fun generateTextId(text: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(text.toByteArray())).toString(16).padStart(32, '0')
    }
}