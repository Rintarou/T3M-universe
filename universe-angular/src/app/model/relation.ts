import { RelationKey } from './relation-key';
export class Relation {
  private _natures: String[] | undefined;
  private _id: RelationKey | undefined;

  public constructor(natures?: String[], id?: RelationKey) {
    this._natures = natures;
    this._id = id;
  }

  /**
   * Getter natures
   * @return {String[] }
   */
  public get natures(): String[] | undefined {
    return this._natures;
  }

  /**
   * Getter id
   * @return {RelationKey }
   */
  public get id(): RelationKey | undefined {
    return this._id;
  }

  /**
   * Setter natures
   * @param {String[] } value
   */
  public set natures(value: String[] | undefined) {
    this._natures = value;
  }

  /**
   * Setter id
   * @param {RelationKey } value
   */
  public set id(value: RelationKey | undefined) {
    this._id = value;
  }
}
