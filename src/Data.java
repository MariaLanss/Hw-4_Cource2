public class Data {
    private static final String VALID_STRING = "abcdefghjiklnmopqrstuvwxyzABCDEFGHJIKLNMOPQRSTUVWXYZ0123456789_";

    public static boolean success(String login,
                                  String password,
                                  String confirmPassword) {
        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void check(String login,
                              String password,
                              String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (validate(login)) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания");
        }
        if (validate(password)) {
            throw new WrongLoginException("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать");
        }
    }

    private static boolean validate(String s) {
        if (s.length() > 20) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_STRING.contains(String.valueOf(s.charAt(i)))) {
                return true;
            }
        }
        return false;
    }
}
