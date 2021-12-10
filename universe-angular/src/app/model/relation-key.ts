export class RelationKey {
  private _parent: Element | undefined;
  private _child: Element | undefined;

  public constructor(child?: Element, parent?: Element) {
    this._child = child;
    this._parent = parent;
  }

  /**
   * Getter parent
   * @return {Element }
   */
  public get parent(): Element | undefined {
    return this._parent;
  }

  /**
   * Getter child
   * @return {Element }
   */
  public get child(): Element | undefined {
    return this._child;
  }
}
