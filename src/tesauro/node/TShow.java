/* This file was generated by SableCC (http://www.sablecc.org/). */

package tesauro.node;

import tesauro.analysis.*;

@SuppressWarnings("nls")
public final class TShow extends Token
{
    public TShow()
    {
        super.setText("show");
    }

    public TShow(int line, int pos)
    {
        super.setText("show");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TShow(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTShow(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TShow text.");
    }
}
