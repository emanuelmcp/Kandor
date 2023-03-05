package io.github.emanuelmcp.kandorauth.util;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {
    /*
        La contraseña tiene al menos 8 caracteres y maximo de 20 caracteres
        La contraseña tiene al menos una letra mayúscula
        La contraseña tiene al menos una letra minúscula
        La contraseña tiene al menos un dígito
        La contraseña tiene al menos un carácter especial
    */
    public static boolean passwordIsValid(@NotNull String password){
        final String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        Pattern passwordPattern = Pattern.compile (PATTERN);
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }
    public static boolean comparePasswords(@NotNull String attempt, String password) {
        return attempt.equals(password);
    }
}
