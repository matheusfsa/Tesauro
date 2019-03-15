/* This file was generated by SableCC (http://www.sablecc.org/). */

package tesauro.node;

import tesauro.analysis.*;

@SuppressWarnings("nls")
public final class TSymVecVal extends Token
{
    public TSymVecVal(String text)
    {
        setText(text);
    }

    public TSymVecVal(String text, int line, int pos)
    {
    	
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TSymVecVal(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTSymVecVal(this);
    }
}
