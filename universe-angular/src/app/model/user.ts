export class User {
  private _id: number | undefined;
  private _login: string | undefined;
  private _password: string | undefined;

  public constructor(id?: number, login?: string, password?: string) {
    this._id = id;
    this._login = login;
    this._password = password;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter login
   * @return {string }
   */
  public get login(): string | undefined {
    return this._login;
  }

  /**
   * Getter password
   * @return {string }
   */
  public get password(): string | undefined {
    return this._password;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter login
   * @param {string } value
   */
  public set login(value: string | undefined) {
    this._login = value;
  }

  /**
   * Setter password
   * @param {string } value
   */
  public set password(value: string | undefined) {
    this._password = value;
  }
}
