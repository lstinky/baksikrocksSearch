package rocks.baksik.searchMicroService.searchSong.exception;

/**
 * Интерфейс для исключений, пробрасываемых при ненахождении сущности.
 */
public interface EntityNotFoundException {
    /**
     * Получение кода ошибки.
     *
     * @return код ошибки.
     */
    String getErrorCode();

    /**
     * Получение сообщения об ошибке.
     *
     * @return сообщение.
     */
    String getErrorMessage();
}
