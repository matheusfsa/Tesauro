/* This file was generated by SableCC (http://www.sablecc.org/). */

package tesauro.node;

import tesauro.analysis.*;

@SuppressWarnings("nls")
public final class TCapture extends Token
{
    public TCapture()
    {
        super.setText("capture");
    }

    public TCapture(int line, int pos)
    {
        super.setText("capture");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TCapture(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTCapture(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TCapture text.");
    }
}
