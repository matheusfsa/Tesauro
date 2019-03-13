/* This file was generated by SableCC (http://www.sablecc.org/). */

package tesauro.node;

import tesauro.analysis.*;

@SuppressWarnings("nls")
public final class AAsLongAsIterationCmd extends PIterationCmd
{
    private PExp _cond_;
    private PCmd _cmdAa_;

    public AAsLongAsIterationCmd()
    {
        // Constructor
    }

    public AAsLongAsIterationCmd(
        @SuppressWarnings("hiding") PExp _cond_,
        @SuppressWarnings("hiding") PCmd _cmdAa_)
    {
        // Constructor
        setCond(_cond_);

        setCmdAa(_cmdAa_);

    }

    @Override
    public Object clone()
    {
        return new AAsLongAsIterationCmd(
            cloneNode(this._cond_),
            cloneNode(this._cmdAa_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAsLongAsIterationCmd(this);
    }

    public PExp getCond()
    {
        return this._cond_;
    }

    public void setCond(PExp node)
    {
        if(this._cond_ != null)
        {
            this._cond_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._cond_ = node;
    }

    public PCmd getCmdAa()
    {
        return this._cmdAa_;
    }

    public void setCmdAa(PCmd node)
    {
        if(this._cmdAa_ != null)
        {
            this._cmdAa_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._cmdAa_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._cond_)
            + toString(this._cmdAa_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._cond_ == child)
        {
            this._cond_ = null;
            return;
        }

        if(this._cmdAa_ == child)
        {
            this._cmdAa_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._cond_ == oldChild)
        {
            setCond((PExp) newChild);
            return;
        }

        if(this._cmdAa_ == oldChild)
        {
            setCmdAa((PCmd) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
