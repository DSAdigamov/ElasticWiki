package ru.vkr.elasticwiki.Util;

import org.apache.commons.lang3.StringUtils;

public class LineCleanupUtil {

    private static final String ADDITIONAL_LINK_1_START = "&lt;ref&gt;";
    private static final String ADDITIONAL_LINK_1_END = "&lt;/ref&gt;";

    private static final String ADDITIONAL_LINK_2_START = "&lt;ref";
    private static final String ADDITIONAL_LINK_2_END = "quot;/&gt;";

    private static final String LANGUAGE_KEYWORD_START = "lang-";

    public static String cleanupLine(String line) {
        line = removeAdditional(line, ADDITIONAL_LINK_1_START, ADDITIONAL_LINK_1_END);
        line = removeAdditional(line, ADDITIONAL_LINK_2_START, ADDITIONAL_LINK_2_END);
        line = translateLanguage(line);
        line = removeSquareBrackets(line);
        line = removeCurlyBrackets(line);

        return line;
    }

    private static String removeAdditional(String line, String additionalStart, String additionalEnd) {
        int indexOfRefStart = line.indexOf(additionalStart);

        if (indexOfRefStart != -1) {
            int indexOfRefEnd = line.indexOf(additionalEnd, indexOfRefStart + additionalStart.length());
            String refToRemove = line.substring(indexOfRefStart, indexOfRefEnd + additionalEnd.length());

            line = removeAdditional(line.replace(refToRemove, ""), additionalStart, additionalEnd);
        }

        return line;
    }

    private static String translateLanguage(String line) {
        int indexOfLangStart = line.indexOf(LANGUAGE_KEYWORD_START);

        if (indexOfLangStart != -1) {
            int indexOfLangEnd = line.indexOf("|", indexOfLangStart);
            String langKey = line.substring(indexOfLangStart + LANGUAGE_KEYWORD_START.length(), indexOfLangEnd);

            line = translateLanguage(line.replace(LANGUAGE_KEYWORD_START + langKey, LanguageUtil.getLanguageMap().get(langKey).getShortName()));
        }


        return line;
    }

    private static String removeSquareBrackets(String line) {
        String insideLine = StringUtils.substringBetween(line, "[[", "]]");

        if (insideLine != null) {
            String[] variations = insideLine.split("\\|");

            if (variations.length >= 2) {
                line = line.replace(variations[0] + "|", "");
            }

            line = line.replaceFirst("\\[\\[", "");
            line = line.replaceFirst("]]", "");
            line = removeSquareBrackets(line);
        }

        return line;
    }

    private static String removeCurlyBrackets(String line) {
        String insideLine = StringUtils.substringBetween(line, "{{", "}}");

        if (insideLine != null) {
            String[] variations = insideLine.split("\\|");

            if (variations.length >= 2 &&  !variations[0].endsWith(".")) {
                line = line.replace(variations[0] + "|", "");
            }

            line = line.replaceFirst("\\{\\{", "");
            line = line.replaceFirst("}}", "");
            line = removeCurlyBrackets(line);
        }

        return line;
    }

    public static boolean isValidLine(String line) {
        return !line.startsWith("{{") && !line.startsWith("[[Файл");
    }
}
