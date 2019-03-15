/* This file was generated by SableCC (http://www.sablecc.org/). */

package tesauro.node;

import tesauro.analysis.*;

@SuppressWarnings("nls")
public final class ASymValExp extends PExp
{
    private TSymVal _symVal_;

    public ASymValExp()
    {
        // Constructor
    }

    public ASymValExp(
        @SuppressWarnings("hiding") TSymVal _symVal_)
    {
        // Constructor
        setSymVal(_symVal_);

    }

    @Override
    public Object clone()
    {
        return new ASymValExp(
            cloneNode(this._symVal_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASymValExp(this);
    }

    public TSymVal getSymVal()
    {
        return this._symVal_;
    }

    public void setSymVal(TSymVal node)
    {
        if(this._symVal_ != null)
        {
            this._symVal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._symVal_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._symVal_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._symVal_ == child)
        {
            this._symVal_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._symVal_ == oldChild)
        {
            setSymVal((TSymVal) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}