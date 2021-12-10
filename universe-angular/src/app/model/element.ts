import { Relation } from './relation';
import { Universe } from './universe';
export class Element {
  private _id: number | undefined;
  private _name: string | undefined;
  private _description: string | undefined;
  private _unique: boolean | undefined;
  private _universe: Universe | undefined;
  private _parentElements: Relation[] | undefined;
  private _childElements: Relation[] | undefined;

  public constructor(
    id?: number,
    name?: string,
    description?: string,
    unique?: boolean,
    universe?: Universe,
    parentElements?: Relation[],
    childElements?: Relation[]
  ) {
    this._id = id;
    this._name = name;
    this._description = description;
    this._unique = unique;
    this._universe = universe;
    this._parentElements = parentElements;
    this._childElements = childElements;
  }

  /**
   * Getter parentElements
   * @return {Relation[] }
   */
  public get parentElements(): Relation[] | undefined {
    return this._parentElements;
  }

  /**
   * Getter childElements
   * @return {Relation[] }
   */
  public get childElements(): Relation[] | undefined {
    return this._childElements;
  }

  /**
   * Setter parentElements
   * @param {Relation[] } value
   */
  public set parentElements(value: Relation[] | undefined) {
    this._parentElements = value;
  }

  /**
   * Setter childElements
   * @param {Relation[] } value
   */
  public set childElements(value: Relation[] | undefined) {
    this._childElements = value;
  }

  /**
   * Getter universe
   * @return {Universe }
   */
  public get universe(): Universe | undefined {
    return this._universe;
  }

  /**
   * Setter universe
   * @param {Universe } value
   */
  public set universe(value: Universe | undefined) {
    this._universe = value;
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
   * Getter description
   * @return {string }
   */
  public get description(): string | undefined {
    return this._description;
  }

  /**
   * Getter unique
   * @return {boolean }
   */
  public get unique(): boolean | undefined {
    return this._unique;
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
   * Setter description
   * @param {string } value
   */
  public set description(value: string | undefined) {
    this._description = value;
  }

  /**
   * Setter unique
   * @param {boolean } value
   */
  public set unique(value: boolean | undefined) {
    this._unique = value;
  }
}
