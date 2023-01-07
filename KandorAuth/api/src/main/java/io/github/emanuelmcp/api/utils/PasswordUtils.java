package io.github.emanuelmcp.api.utils;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {

    @Contract(pure = true)
    public static @NotNull String encryptPassword(@NotNull String password){
        StrongPasswordEncryptor encodedPassword = new StrongPasswordEncryptor();
        return encodedPassword.encryptPassword(password);
    }

    public static boolean comparePassword(@NotNull String word, @NotNull String password){
        return new StrongPasswordEncryptor().checkPassword(word, password);
    }
    public static boolean ifSamePasswords(@NotNull String password, @NotNull String confirmPassword){
        return password.equals(confirmPassword);
    }

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
}
