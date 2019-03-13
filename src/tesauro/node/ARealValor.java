/* This file was generated by SableCC (http://www.sablecc.org/). */

package tesauro.node;

import tesauro.analysis.*;

@SuppressWarnings("nls")
public final class ARealValor extends PValor
{
    private TRealVal _realVal_;

    public ARealValor()
    {
        // Constructor
    }

    public ARealValor(
        @SuppressWarnings("hiding") TRealVal _realVal_)
    {
        // Constructor
        setRealVal(_realVal_);

    }

    @Override
    public Object clone()
    {
        return new ARealValor(
            cloneNode(this._realVal_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARealValor(this);
    }

    public TRealVal getRealVal()
    {
        return this._realVal_;
    }

    public void setRealVal(TRealVal node)
    {
        if(this._realVal_ != null)
        {
            this._realVal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._realVal_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._realVal_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._realVal_ == child)
        {
            this._realVal_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._realVal_ == oldChild)
        {
            setRealVal((TRealVal) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
