/* This file was generated by SableCC (http://www.sablecc.org/). */

package tesauro.node;

import tesauro.analysis.*;

@SuppressWarnings("nls")
public final class AConsideringIterationCmdNoShortIct extends PIterationCmdNoShortIct
{
    private PExp _i_;
    private PExp _ini_;
    private PExp _fim_;
    private PExp _inc_;
    private PCmdNoShortIct _cmdCons_;

    public AConsideringIterationCmdNoShortIct()
    {
        // Constructor
    }

    public AConsideringIterationCmdNoShortIct(
        @SuppressWarnings("hiding") PExp _i_,
        @SuppressWarnings("hiding") PExp _ini_,
        @SuppressWarnings("hiding") PExp _fim_,
        @SuppressWarnings("hiding") PExp _inc_,
        @SuppressWarnings("hiding") PCmdNoShortIct _cmdCons_)
    {
        // Constructor
        setI(_i_);

        setIni(_ini_);

        setFim(_fim_);

        setInc(_inc_);

        setCmdCons(_cmdCons_);

    }

    @Override
    public Object clone()
    {
        return new AConsideringIterationCmdNoShortIct(
            cloneNode(this._i_),
            cloneNode(this._ini_),
            cloneNode(this._fim_),
            cloneNode(this._inc_),
            cloneNode(this._cmdCons_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAConsideringIterationCmdNoShortIct(this);
    }

    public PExp getI()
    {
        return this._i_;
    }

    public void setI(PExp node)
    {
        if(this._i_ != null)
        {
            this._i_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._i_ = node;
    }

    public PExp getIni()
    {
        return this._ini_;
    }

    public void setIni(PExp node)
    {
        if(this._ini_ != null)
        {
            this._ini_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ini_ = node;
    }

    public PExp getFim()
    {
        return this._fim_;
    }

    public void setFim(PExp node)
    {
        if(this._fim_ != null)
        {
            this._fim_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._fim_ = node;
    }

    public PExp getInc()
    {
        return this._inc_;
    }

    public void setInc(PExp node)
    {
        if(this._inc_ != null)
        {
            this._inc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._inc_ = node;
    }

    public PCmdNoShortIct getCmdCons()
    {
        return this._cmdCons_;
    }

    public void setCmdCons(PCmdNoShortIct node)
    {
        if(this._cmdCons_ != null)
        {
            this._cmdCons_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._cmdCons_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._i_)
            + toString(this._ini_)
            + toString(this._fim_)
            + toString(this._inc_)
            + toString(this._cmdCons_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._i_ == child)
        {
            this._i_ = null;
            return;
        }

        if(this._ini_ == child)
        {
            this._ini_ = null;
            return;
        }

        if(this._fim_ == child)
        {
            this._fim_ = null;
            return;
        }

        if(this._inc_ == child)
        {
            this._inc_ = null;
            return;
        }

        if(this._cmdCons_ == child)
        {
            this._cmdCons_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._i_ == oldChild)
        {
            setI((PExp) newChild);
            return;
        }

        if(this._ini_ == oldChild)
        {
            setIni((PExp) newChild);
            return;
        }

        if(this._fim_ == oldChild)
        {
            setFim((PExp) newChild);
            return;
        }

        if(this._inc_ == oldChild)
        {
            setInc((PExp) newChild);
            return;
        }

        if(this._cmdCons_ == oldChild)
        {
            setCmdCons((PCmdNoShortIct) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
