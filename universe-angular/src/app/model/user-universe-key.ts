import { Universe } from './universe';
import { User } from './user';
import { AccessRight } from './AccessRight';
export class UserUniverseKey {
  private _user: User | undefined;
  private _universe: Universe | undefined;

  public constructor(user?: User, universe?: Universe) {
    this._user = user;
    this._universe = universe;
  }

  /**
   * Getter user
   * @return {User }
   */
  public get user(): User | undefined {
    return this._user;
  }

  /**
   * Getter universe
   * @return {Universe }
   */
  public get universe(): Universe | undefined {
    return this._universe;
  }

  /**
   * Setter user
   * @param {User } value
   */
  public set user(value: User | undefined) {
    this._user = value;
  }

  /**
   * Setter universe
   * @param {Universe } value
   */
  public set universe(value: Universe | undefined) {
    this._universe = value;
  }
}
