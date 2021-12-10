import { UserUniverse } from './user-universe';
export class Universe {
  private _id: number | undefined;
  private _name: string | undefined;
  private _userUniverses: UserUniverse[] | undefined;
  private _elements: Element[] | undefined;

  public constructor(
    id?: number,
    name?: string,
    userUniverses?: UserUniverse[],
    elements?: Element[]
  ) {
    this._id = id;
    this._name = name;
    this._userUniverses = userUniverses;
    this._elements = elements;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter name
   * @return {string }
   */
  public get name(): string | undefined {
    return this._name;
  }

  /**
   * Getter userUniverses
   * @return {[UserUniverse] }
   */
  public get userUniverses(): UserUniverse[] | undefined {
    return this._userUniverses;
  }

  /**
   * Getter elements
   * @return {[Element] }
   */
  public get elements(): Element[] | undefined {
    return this._elements;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter name
   * @param {string } value
   */
  public set name(value: string | undefined) {
    this._name = value;
  }

  /**
   * Setter userUniverses
   * @param {[UserUniverse] } value
   */
  public set userUniverses(value: UserUniverse[] | undefined) {
    this._userUniverses = value;
  }

  /**
   * Setter elements
   * @param {[Element] } value
   */
  public set elements(value: Element[] | undefined) {
    this._elements = value;
  }
}
