import { UserUniverseKey } from './user-universe-key';
import { AccessRight } from './AccessRight';
export class UserUniverse {
  private _accessRight: AccessRight | undefined;
  private _id: UserUniverseKey | undefined;

  public constructor(accessRight?: AccessRight, id?: UserUniverseKey) {
    this._accessRight = accessRight;
    this._id = id;
  }

  /**
   * Getter accessRight
   * @return {AccessRight }
   */
  public get accessRight(): AccessRight | undefined {
    return this._accessRight;
  }

  /**
   * Getter id
   * @return {UserUniverseKey }
   */
  public get id(): UserUniverseKey | undefined {
    return this._id;
  }

  /**
   * Setter accessRight
   * @param {AccessRight } value
   */
  public set accessRight(value: AccessRight | undefined) {
    this._accessRight = value;
  }

  /**
   * Setter id
   * @param {UserUniverseKey } value
   */
  public set id(value: UserUniverseKey | undefined) {
    this._id = value;
  }
}
