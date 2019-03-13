/* This file was generated by SableCC (http://www.sablecc.org/). */

package tesauro.node;

import tesauro.analysis.*;

@SuppressWarnings("nls")
public final class TDo extends Token
{
    public TDo()
    {
        super.setText("do");
    }

    public TDo(int line, int pos)
    {
        super.setText("do");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TDo(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTDo(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TDo text.");
    }
}
