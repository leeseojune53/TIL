export class TokenResponse {
    constructor(access_token: string, refresh_token: string) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
    }
    access_token: string;
    refresh_token: string;
}