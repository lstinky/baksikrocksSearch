package rocks.baksik.searchMicroService.searchSong.exception;

public class ValueException extends RuntimeException {

    public ValueException(String message) {
        super(message);
    }

    /**
     * Значение не найдено
     */
    public static final class NotFound extends ValueException implements EntityNotFoundException{
        public NotFound() {
            super("Ничего не найдено");
        }

        @Override
        public String getErrorCode() {
            return "CDLC";
        }

        @Override
        public String getErrorMessage() {
            return "Ничего не найдено";
        }
    }
}