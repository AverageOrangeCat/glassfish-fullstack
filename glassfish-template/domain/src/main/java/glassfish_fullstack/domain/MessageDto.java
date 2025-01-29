package glassfish_fullstack.domain;

public class MessageDto {

    private Long id;

    private String username;

    private String context;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContext() {
        return this.context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public MessageDto() {}

    private MessageDto(Builder builder) {
        this.id = builder.id;

        this.username = builder.username;

        this.context = builder.context;
    }

    public static class Builder {

        private Long id;

        private String username;

        private String context;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setContext(String context) {
            this.context = context;
            return this;
        }

        public MessageDto build() {
            return new MessageDto(this);
        }

    }

}
